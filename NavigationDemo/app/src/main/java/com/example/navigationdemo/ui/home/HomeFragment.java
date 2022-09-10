package com.example.navigationdemo.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdemo.R;
import com.example.navigationdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private static final String TAG = "HomeFragment";
    private ListView listView;
    View view;
    private UserAccount[] users;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        this.listView = (ListView) view.findViewById(R.id.listView);
        initiListViewData();
        ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_checked, this.users);
        this.listView.setAdapter(arrayAdapter);
        for(int i = 0; i < users.length; i++) {
            this.listView.setItemChecked(i, users[i].isActive());
        }
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick " + position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                UserAccount user = (UserAccount) listView.getItemAtPosition(position);
                user.setActive(!currentCheck);
            }
        });
        return view;
    }

    public void initiListViewData()
    {
        UserAccount tom = new UserAccount("TOM", "admin", false);
        UserAccount jerry = new UserAccount("Jerry", "user", false);
        UserAccount cat = new UserAccount("CAT", "user", false);
        this.users = new UserAccount[]{tom, jerry, cat};
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
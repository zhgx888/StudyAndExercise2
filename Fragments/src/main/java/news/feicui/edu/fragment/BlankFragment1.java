package news.feicui.edu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        View view=lf.inflate(R.layout.fragment_blank1, container, false);
        TextView txt= (TextView) view.findViewById(R.id.bf1_txt);
        txt.setText("欢迎使用Fragment1");
        // Inflate the layout for this fragment
        return view;
    }

}

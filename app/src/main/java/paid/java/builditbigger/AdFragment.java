package paid.java.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.FetchJoksTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdFragment extends Fragment {

    private ProgressBar progressBar;

    public AdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        progressBar = (ProgressBar) v.findViewById(R.id.progressbar);

        tellJoks();
        return v;
    }

    private void tellJoks() {

        final FetchJoksTask task = new FetchJoksTask(progressBar, getContext());
        task.execute();

    }


}



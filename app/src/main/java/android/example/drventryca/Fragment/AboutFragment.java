package android.example.drventryca.Fragment;

import android.example.drventryca.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {

    private ImageView logo;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        logo = view.findViewById(R.id.logo);

        logo.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_scale));


        return view;
    }
}

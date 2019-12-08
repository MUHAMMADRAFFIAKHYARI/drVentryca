package android.example.drventryca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;


public class FTSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;



    public FTSliderAdapter(Context context){
        this.context = context;

        faktatips_slide = context.getResources().getStringArray(R.array.fakta_tips);
    }

    public String[] faktatips_slide;


    @Override
    public int getCount() {
        return faktatips_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        RelativeLayout all_ft;

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_fakta_tips,container,false);


        TextView text_faktatips = view.findViewById(R.id.text_FaktaTips);
        TextView text_count = view.findViewById(R.id.hal_count);

        all_ft = view.findViewById(R.id.all_ft);
        all_ft.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate_y_show3));


        text_faktatips.setText(faktatips_slide[position]);
        int total = faktatips_slide.length;

        text_count.setText(position+1+" / "+total);
        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}

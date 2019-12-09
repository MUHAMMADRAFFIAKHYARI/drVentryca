package android.example.drventryca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class FTSliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


    public FTSliderAdapter(Context context){
        this.context = context;

        faktatips_slide = context.getResources().getStringArray(R.array.fakta_tips);
    }

    public interface OnItemClickListener {
        void onChoiceClick(int position);
    }

    public String[] faktatips_slide;


    @Override
    public int getCount() {
        return faktatips_slide.length;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_fakta_tips,container,false);


        TextView text_faktatips = view.findViewById(R.id.text_FaktaTips);
        /*TextView text_count = view.findViewById(R.id.counter_hal);*/
        text_faktatips.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate_y_show3));
        text_faktatips.setText(faktatips_slide[position]);

        /*int total = getCount();
        text_count.setText(position+1+" / "+total);
*/
        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}

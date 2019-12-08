package android.example.drventryca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int [] slide_images = {R.drawable.ichigo, R.drawable.diagnosis_home, R.drawable.zeroone};
    public String [] slide_headings = { "DATA PENYAKIT", "DIAGNOSIS", "FAKTA & TIPS KESEHATAN" };
    public String [] slide_decs = {
            "Tersedia data - data penyakit yang berhubungan dengan pencernaan",
            "Serangkaian diagnosis untuk mengetahui penyakit yang diderita",
            "Fakta dan tips kesehatan untuk hidup lebih sehat melalui makanan"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_decs[position]);

        container.addView(view);

        return  view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}

package com.alibus.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibus.R;
import com.alibus.activity.Imageloader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-28 下午5:15
 * 修改人：alibus
 * 修改时间：16-3-28 下午5:15
 * 修改备注：
 */
public class GridImageAdapter extends BaseAdapter {

    Context mContext;
    List<String> list;


    public GridImageAdapter(Context context, List urlList) {

        this.mContext = context;
        this.list = urlList;

    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        if (null == list || list.size() == 0) {
            return 0;
        }

        return list.size();
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image;
        if (null == view) {
            image = new ImageView(mContext);
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //ViewHolder holder = new ViewHolder(view);
            //view.setTag(holder);
        }else{
            image = (ImageView) view;
        }
        Bitmap bp = ImageLoader.getInstance().loadImageSync(list.get(i));
        image.setImageBitmap(bp);

        return image;
    }

    private class ViewHolder {
        public ViewHolder(ImageView view) {
            this.imageView = view;
        }

        ImageView imageView;
    }
}

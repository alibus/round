package com.alibus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibus.R;
/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-24 下午2:37
 * 修改人：alibus
 * 修改时间：16-3-24 下午2:37
 * 修改备注：
 */
public class ToolBarView extends LinearLayout{

    private Context mContext;

    private TextView opposeView;
    private TextView supportView;
    private ImageButton supportBtn;
    private ImageButton opposeBtn;
    private ImageButton shareBtn;


    public ToolBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public ToolBarView(Context context) {
        super(context);
        mContext = context;
    }

    public ToolBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public ToolBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mContext = mContext;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.listview_item_toolbar,this);
    }


    public TextView getOpposeView() {
        return opposeView;
    }

    public ImageButton getShareBtn() {
        return shareBtn;
    }

    public ImageButton getOpposeBtn() {
        return opposeBtn;
    }

    public ImageButton getSupportBtn() {
        return supportBtn;
    }

    public TextView getSupportView() {
        return supportView;
    }


}

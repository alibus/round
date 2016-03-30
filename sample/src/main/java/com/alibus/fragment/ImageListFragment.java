package com.alibus.fragment;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.alibus.adapter.GridImageAdapter;
import com.alibus.bean.ItemInfo;
import com.alibus.view.ImageGridView;
import com.alibus.view.RoundImageView;
import com.alibus.R;


import com.alibus.view.ToolBarView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;

/**
 * 项目名称：round
 * 类描述：
 * 创建人：alibus
 * 创建时间：16-3-23 下午5:52
 * 修改人：alibus
 * 修改时间：16-3-23 下午5:52
 * 修改备注：
 */
public class ImageListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    ReclyclerAdapter myAdapter;

    String url = "http://b.zol-img.com.cn/sjbizhi/images/2/320x510/1356078347925.jpg";

    String url2 = "http://cdn.duitang.com/uploads/item/201409/13/20140913141520_Ydidj.jpeg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_list_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }


    public ItemInfo testView(){
        ItemInfo info = new ItemInfo();
        info.setDescribe("it tkkdkfkk kkdfkkkd kdkkfdkfkk");
        info.setUsername("alibus");
        info.setImageUri(url);
        List list = new ArrayList<String>();
        list.add(url);
        list.add(url);
        //list.add(url);
        //list.add(url);
        //list.add(url);
        info.setPriviewList(list);
        return info;
    }

    private void initView(View view){
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_id);
        recyclerView = (RecyclerView)view.findViewById(R.id.image_list);
        ArrayList<ItemInfo> listItem = new ArrayList<ItemInfo>();
        listItem.add(testView());
        myAdapter = new ReclyclerAdapter(getActivity(),listItem);
        recyclerView.setAdapter(myAdapter);
        //testView();
        refreshLayout.setOnRefreshListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



    }

    @Override
    public void onRefresh() {

    }

    private class ReclyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        int MAX_ITEM = 200;

        LayoutInflater mLayoutInflater;

        List<ItemInfo> itemList;

        DisplayImageOptions options;


        public ReclyclerAdapter(Context context){

            mLayoutInflater = LayoutInflater.from(context);

            options = setImageUrlOption();

        }


        public ReclyclerAdapter(Context context,List list){

            mLayoutInflater = LayoutInflater.from(context);

            options = setImageUrlOption();

            itemList = list;

        }

        public void addItemInfo(ItemInfo itemInfo){
            if(itemList == null){
                itemList = new ArrayList<ItemInfo>();
            }
            itemList.add(itemInfo);
            notifyDataSetChanged();
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            constructView((AliViewHolder)viewHolder,i);
        }

        @Override
        public int getItemCount() {
            if(null == itemList || itemList.size() == 0){
                return 0;
            }
            return itemList.size();

        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        private void constructView(AliViewHolder viewHolder,int postion){

            ItemInfo info = itemList.get(postion);
            viewHolder.userName.setText(info.getUsername());
            //ImageLoader.getInstance().loadImage(info.getImageUri(),options,null);
            viewHolder.userImage.setImageDrawable(getResources().getDrawable(R.drawable.head));
            viewHolder.describeView.setText(info.getDescribe());
            if(null != info.getPriviewList() && info.getPriviewList().size()>0){
                GridImageAdapter imageAdapter = new GridImageAdapter(getActivity().getApplicationContext(),info.getPriviewList());
                viewHolder.gridView.setAdapter(imageAdapter);
                viewHolder.gridView.setVisibility(View.VISIBLE);
            }else{
                viewHolder.gridView.setVisibility(View.GONE);

            }

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new AliViewHolder(mLayoutInflater.inflate(R.layout.list_item,null));
        }
    }

    private class AliViewHolder extends RecyclerView.ViewHolder{
        public AliViewHolder(View itemView){
            super(itemView);
            init(itemView);
        }

        public TextView userName;
        public TextView describeView;
        public ImageGridView gridView;
        public RoundImageView userImage;
        public ToolBarView toolBarView;

        private void init(View view){

            View userinfo = view.findViewById(R.id.user_info);
            userName = (TextView)userinfo.findViewById(R.id.user_name);
            userImage = (RoundImageView)userinfo.findViewById(R.id.user_iamge);
            gridView = (ImageGridView)view.findViewById(R.id.grid_view);
            toolBarView = (ToolBarView)view.findViewById(R.id.toolBar_view);
            describeView = (TextView)view.findViewById(R.id.describe_id);
        }

    }

    private DisplayImageOptions setImageUrlOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.head) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.head) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.head) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build();
        return options;
    }


}

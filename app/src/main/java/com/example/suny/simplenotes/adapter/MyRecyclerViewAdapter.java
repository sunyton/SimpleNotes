package com.example.suny.simplenotes.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suny.simplenotes.R;
import com.example.suny.simplenotes.database.DatabaseHelper;
import com.example.suny.simplenotes.utils.Constant;
import com.example.suny.simplenotes.utils.InfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suny on 2017/5/14.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolder> {


    private List<InfoBean> mInfoBeen;


    public MyRecyclerViewAdapter(Context context) {
        mInfoBeen = initList(context);
        Log.i("ggg", mInfoBeen.toString());

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.tv_yue.setText(mInfoBeen.get(position).getTime_yue()+"/"+mInfoBeen.get(position).getTime_week());
        holder.tv_ri.setText(mInfoBeen.get(position).getTime_ri());
        holder.tv_loc.setText(mInfoBeen.get(position).getLocation());
        holder.tv_time.setText(mInfoBeen.get(position).getTime_hm());
        holder.tv_body.setText(mInfoBeen.get(position).getBody());
        holder.tv_weather.setText(mInfoBeen.get(position).getWeather());

    }

    @Override
    public int getItemCount() {
        return mInfoBeen.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView tv_ri,tv_loc, tv_time,tv_yue,tv_body,tv_weather;

        public MyHolder(View itemView) {
            super(itemView);
            tv_ri = (TextView) itemView.findViewById(R.id.time_ri);
            tv_yue = (TextView) itemView.findViewById(R.id.time_yue);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_loc = (TextView) itemView.findViewById(R.id.tv_loc);
            tv_body = (TextView) itemView.findViewById(R.id.tv_body);
            tv_weather = (TextView) itemView.findViewById(R.id.list_weather);

        }
    }


    public List<InfoBean> initList(Context context) {

        List<InfoBean> infoBeanList = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from note order by _id desc";

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            InfoBean infoBean = new InfoBean();
            infoBean.setBody(cursor.getString(cursor.getColumnIndex(Constant.BODY)));
            infoBean.setLocation(cursor.getString(cursor.getColumnIndex(Constant.LOCATION)));
            infoBean.setWeather(cursor.getString(cursor.getColumnIndex(Constant.WEATHER)));
            infoBean.setTime_hm(cursor.getString(cursor.getColumnIndex(Constant.TIME)).split(" ")[3].substring(0,5));
            infoBean.setTime_ri(cursor.getString(cursor.getColumnIndex(Constant.TIME)).split(" ")[2].substring(0,2));
            infoBean.setTime_yue(cursor.getString(cursor.getColumnIndex(Constant.TIME)).split(" ")[1].substring(0,3));
            infoBean.setTime_week(cursor.getString(cursor.getColumnIndex(Constant.TIME)).split(" ")[0].substring(1,4));

            infoBeanList.add(infoBean);

        }

        cursor.close();
        db.close();
        return infoBeanList;

    }
}

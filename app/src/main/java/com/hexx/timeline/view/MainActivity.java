package com.hexx.timeline.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hexx.timeline.R;
import com.hexx.timeline.base.BaseActivity;
import com.hexx.timeline.contract.IMainContract;
import com.hexx.timeline.presenter.MainPresenter;
import com.hexx.timeline.widget.recycler.CommonAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IMainView {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.rv_time_list)
    RecyclerView mRvTimeList;
    CommonAdapter<String, Holder> mAdapter;


    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected String getToolbarTitle() {
        return "时间线";
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        mPresenter.getInfo();
    }


    @Override
    protected void initView() {
        mAdapter = new CommonAdapter<String, Holder>(this) {
            @Override
            public Holder getHolder(ViewGroup viewGroup) {
                return new Holder(viewGroup);
            }
        };
        mRvTimeList.setLayoutManager(new LinearLayoutManager(this));
        mRvTimeList.setAdapter(mAdapter);
    }

    List<String> data = new ArrayList<>();

    @Override
    public void succ(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        for (int i = 0; i < 10; i++) {
            data.add(String.format(Locale.CHINA, "This is item %d", i));
        }
        mAdapter.add(data);

    }

    class Holder extends CommonAdapter.BaseHolder<String> {
        @BindView(R.id.tv_content)
        TextView mTvContent;

        public Holder(ViewGroup viewGroup) {
            super(MainActivity.this, R.layout.item_time_layout, viewGroup);
        }

        @Override
        public void bindData(String data) {
            mTvContent.setText(data);
        }
    }
}

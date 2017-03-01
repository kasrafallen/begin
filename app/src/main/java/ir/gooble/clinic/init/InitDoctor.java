package ir.gooble.clinic.init;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import ir.gooble.clinic.activity.MainActivity;
import ir.gooble.clinic.adaptor.DoctorAdaptor;
import ir.gooble.clinic.application.BaseActivity;
import ir.gooble.clinic.application.BaseInit;
import ir.gooble.clinic.view.AppRecyclerView;
import ir.gooble.clinic.view.AppToolbar;

public class InitDoctor extends BaseInit {
    private static final int TOOLBAR_ID = +8248484;

    private final DoctorAdaptor adaptor;
    private MainActivity context;
    private AppToolbar toolbar;

    public AppRecyclerView recyclerView;

    public InitDoctor(BaseActivity context) {
        super(context);
        this.context = (MainActivity) context;
        this.adaptor = new DoctorAdaptor(context, dimen);
    }

    @Override
    protected View create() {
        CoordinatorLayout layout = new CoordinatorLayout(context);
        layout.setLayoutParams(new DrawerLayout.LayoutParams(-1, -1));
        layout.addView(toolbar());
        layout.addView(recycler());
        return layout;
    }

    private View recycler() {
        recyclerView = new AppRecyclerView(context);
        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(-1, -2);
        params.topMargin = toolbar.getSize();
        recyclerView.setLayoutParams(params);
        GridLayoutManager manager = new GridLayoutManager(context, 2);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 100;
//            }
//        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptor);
        return recyclerView;
    }

    private View toolbar() {
        toolbar = new AppToolbar(context, true, "معرفی پزشکان", true);
        toolbar.setId(TOOLBAR_ID);
        return toolbar;
    }
}

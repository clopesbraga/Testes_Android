package br.com.branch.testes.Telas.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.branch.testes.R;
import br.com.branch.testes.TabelasSemana.Tab1;
import br.com.branch.testes.TabelasSemana.Tab2;
import br.com.branch.testes.TabelasSemana.Tab3;
import br.com.branch.testes.TabelasSemana.Tab4;
import br.com.branch.testes.TabelasSemana.Tab5;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5,R.string.tab_text_6};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;

       switch(position){

           case 0: fragment = new Tab1();
           break;

           case 1: fragment = new Tab2();
           break;

           case 2: fragment = new Tab3();
           break;

           case 3: fragment = new Tab4();
           break;

           case 4: fragment = new Tab4();
           break;

           case 5: fragment = new Tab5();
           break;

       }

      return fragment;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }
}
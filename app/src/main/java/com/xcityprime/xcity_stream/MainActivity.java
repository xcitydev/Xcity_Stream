package com.xcityprime.xcity_stream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerPageAdapter bannerPageAdapter;
    ViewPager viewPager;
    List<BannerMovies> homeMovies;
    List<BannerMovies> movies;
    List<BannerMovies> newReleaseMovies;
    List<BannerMovies> kidMovies;
    TabLayout IndicatorTab, categoryTab;
    List<AllCategory> allCategoryList1;
    List<CategoryItem> categoryItems1;
    List<CategoryItem> categoryItems2;
    List<CategoryItem> categoryItems3;
    AllCategoryAdapter allCategoryAdapter;
    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;
    RecyclerView allCategoryRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IndicatorTab = findViewById(R.id.indicator);
        categoryTab = findViewById(R.id.tabLayout2);
        nestedScrollView = findViewById(R.id.nest_scroll);
        appBarLayout = findViewById(R.id.appbar);
        homeMovies = new ArrayList<>();
        homeMovies.add(new BannerMovies("1", "COLLIDE", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner7.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMovies.add(new BannerMovies("2", "HOBBS AND SHAW", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner2.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMovies.add(new BannerMovies("3", "THE INVISIBLE MAN", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner3.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMovies.add(new BannerMovies("4", "EXTINCTION", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner4.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMovies.add(new BannerMovies("5", "THE SNIPER: ULTIMATE KILL", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/homebanner5.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));

        movies = new ArrayList<>();
        newReleaseMovies = new ArrayList<>();
        kidMovies = new ArrayList<>();

        movies.add(new BannerMovies("1", "COLLIDE", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/moviebanner1.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movies.add(new BannerMovies("2", "HOBBS AND SHAW", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/moviebanner2.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movies.add(new BannerMovies("3", "THE INVISIBLE MAN", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/moviebanner3.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movies.add(new BannerMovies("4", "EXTINCTION", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/moviebanner4.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok,mp4"));
        movies.add(new BannerMovies("5", "THE SNIPER: ULTIMATE KILL", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/moviebanner5.png","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));

        newReleaseMovies.add(new BannerMovies("1", "COLLIDE", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/tvshowbanner1.png",""));
        newReleaseMovies.add(new BannerMovies("2", "HOBBS AND SHAW", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/tvshowbanner2.png",""));
        newReleaseMovies.add(new BannerMovies("3", "THE INVISIBLE MAN", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/tvshowbanner3.png",""));
        newReleaseMovies.add(new BannerMovies("4", "EXTINCTION", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/tvshowbanner4.png",""));
        newReleaseMovies.add(new BannerMovies("5", "THE SNIPER: ULTIMATE KILL", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/tvshowbanner5.png",""));

        kidMovies.add(new BannerMovies("1", "COLLIDE", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/kidsbanner1.png",""));
        kidMovies.add(new BannerMovies("2", "HOBBS AND SHAW", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/kidsbanner2.png",""));
        kidMovies.add(new BannerMovies("3", "THE INVISIBLE MAN", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/kidsbanner3.png",""));
        kidMovies.add(new BannerMovies("4", "EXTINCTION", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/kidsbanner4.png",""));
        kidMovies.add(new BannerMovies("5", "THE SNIPER: ULTIMATE KILL", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/banners/kidsbanner5.png",""));

        setBannerPageAdapter(homeMovies);

        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch(tab.getPosition()){
                   case 1:
                       setScrollDefault();
                       setBannerPageAdapter(movies);
                       return;
                   case 2:
                       setScrollDefault();
                       setBannerPageAdapter(newReleaseMovies);
                       return;
                   case 3:
                       setScrollDefault();
                       setBannerPageAdapter(kidMovies);
                       return;
                   default:
                       setScrollDefault();
                       setBannerPageAdapter(homeMovies);
               }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        categoryItems1 = new ArrayList<>();
        categoryItems1.add(new CategoryItem(1, "Love & Drugs","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0c31d2e9b7a93da1a5e9110377715b2ce2caa9b4aee69de54be289d0d4992738._UR1920,1080_RI_SX356_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        categoryItems1.add(new CategoryItem(2, "Monster","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/4a0bd5b6cff38faf567b0627ab82b44411ca66876d4534e8bd0bfcf514a535f5._UR1920,1080_RI_SX356_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        categoryItems1.add(new CategoryItem(3, "Love Games","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bee4c34123ee1b254dc1d55abc8f708b34a3827892588d6819d5c20fd6a5da13._UR1920,1080_RI_SX712_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/"));
        categoryItems1.add(new CategoryItem(4, "","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/54d263b84f8d46fdf664fc2561ae4371d2ec6533634e59a3634f44c74c040054._UR1920,1080_RI_SX712_FMwebp_.jpg","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/54d263b84f8d46fdf664fc2561ae4371d2ec6533634e59a3634f44c74c040054._UR1920,1080_RI_SX712_FMwebp_.jpg"));

        categoryItems2 = new ArrayList<>();
        categoryItems2.add(new CategoryItem(1, "Love & Drugs","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/bee4c34123ee1b254dc1d55abc8f708b34a3827892588d6819d5c20fd6a5da13._UR1920,1080_RI_SX712_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        categoryItems2.add(new CategoryItem(2, "Monster","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/d7c6ad0bbd2ba9e09b6bebca5bc41eac6286aff64962ce90797b79c0d26c9379._UR1920,1080_RI_SX356_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        categoryItems2.add(new CategoryItem(3, "XPrime","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/4a0bd5b6cff38faf567b0627ab82b44411ca66876d4534e8bd0bfcf514a535f5._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        categoryItems2.add(new CategoryItem(4, "","",""));

        categoryItems3 = new ArrayList<>();
        categoryItems3.add(new CategoryItem(1, "Love & Drugs","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/54d263b84f8d46fdf664fc2561ae4371d2ec6533634e59a3634f44c74c040054._UR1920,1080_RI_SX712_FMwebp_.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        categoryItems3.add(new CategoryItem(2, "Monster","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/2f813d581199099922bd238aa1d407babc3b3bf5112bb835b95c26fabda69e9a._UR1920,1080_RI_SX712_FMwebp_.jpg",""));
        categoryItems3.add(new CategoryItem(3, "Ghost","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/4a0bd5b6cff38faf567b0627ab82b44411ca66876d4534e8bd0bfcf514a535f5._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        categoryItems3.add(new CategoryItem(4, "Extinction","","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/d7c6ad0bbd2ba9e09b6bebca5bc41eac6286aff64962ce90797b79c0d26c9379._UR1920,1080_RI_SX356_FMwebp_.jpg"));

        allCategoryList1 = new ArrayList<>();
        allCategoryList1.add(new AllCategory(1, "HollyWood", categoryItems1));
        allCategoryList1.add(new AllCategory(2, "BollyWood", categoryItems2));
        allCategoryList1.add(new AllCategory(3, "NollyWood", categoryItems3));
        allCategoryList1.add(new AllCategory(4, "X-city Prime", categoryItems1));

        setMainRecycler(allCategoryList1);
    }
    private void setBannerPageAdapter(List<BannerMovies> bannerLists) {
        viewPager = findViewById(R.id.viewPager);
        bannerPageAdapter = new BannerPageAdapter(this, bannerLists);
        viewPager.setAdapter(bannerPageAdapter);
        IndicatorTab.setupWithViewPager(viewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(), 7000, 12000);
        IndicatorTab.setupWithViewPager(viewPager, true);
    }

    class AutoSlider extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < homeMovies.size() - 1){
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void setMainRecycler(List<AllCategory> allCategoryList){
        allCategoryRecycleView = findViewById(R.id.recycleView);
        allCategoryRecycleView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        allCategoryAdapter = new AllCategoryAdapter(this, allCategoryList);
        allCategoryRecycleView.setAdapter(allCategoryAdapter);
    }

    private void setScrollDefault(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}

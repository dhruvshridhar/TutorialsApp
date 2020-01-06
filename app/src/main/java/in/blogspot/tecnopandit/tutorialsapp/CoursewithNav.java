package in.blogspot.tecnopandit.tutorialsapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class CoursewithNav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment,frag;
    TextView navuser;
    DrawerLayout drawer;
Bundle b;
public void putfrag(){
    fragment = new BlankFragment();
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.fragment2,fragment);
    ft.commit();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursewith_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headview = navigationView.getHeaderView(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Dashboard");
        navuser=(TextView)headview.findViewById(R.id.navuser);
        b=getIntent().getExtras();
        navuser.setText(b.getString("username"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.coursewith_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
            putfrag();
        } else if (id == R.id.courses) {
            fragment = new BlankFragment2();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragment2,fragment);
            ft.commit();
            Toast.makeText(this,"Courses",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.test) {
            Toast.makeText(this,"Tests",Toast.LENGTH_SHORT).show();
            fragment = new BlankFragment2();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragment2,fragment);
            ft.commit();
        } else if (id == R.id.promember) {
        } else if (id == R.id.about) {
            Intent in=new Intent(this,AboutContact.class);
            startActivity(in);
        } else if (id == R.id.contact) {
            Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.logout) {
            Intent i= new Intent(this,MainActivity.class);
            Toast.makeText(this,"Successfully Logged out",Toast.LENGTH_SHORT).show();
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void seemore(View view)
    {
        fragment = new BlankFragment2();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment2,fragment);
        ft.addToBackStack("see");
        ft.commit();
    }
    public void playvid(View view)
    {   fragment = new VideoListFrag();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment2,fragment);
        ft.commit();
    }
    public void playlecture(View view)
    {
        Intent play=new Intent(this,VideoPlayer.class);
        startActivity(play);
    }

}

package com.ubiss2018.dev.ubiss2018;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by muradahmad on 06/06/2018.
 */

public class SessionSetting extends Activity {

    /*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Map<String, String>> list = buildData();
        String[] from = { "name", "purpose" };
        int[] to = { android.R.id.text1, android.R.id.text2 };

        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.session_setting, from, to);
        setListAdapter(adapter);
    }

    private ArrayList<Map<String, String>> buildData() {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(putData("Android", "Mobile"));
        list.add(putData("Windows7", "Windows7"));
        list.add(putData("iPhone", "iPhone"));
        return list;
    }

    private HashMap<String, String> putData(String name, String purpose) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("name", name);
        item.put("purpose", purpose);
        return item;
    }
*/


    Button btnPlay;


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);


 /*       Button btnSessionSetting = (Button) findViewById(R.id.session);
       btnSessionSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SessionData.this,SessionSetting.class);
                startActivity(intent);

            }
        });*/

        btnPlay = (Button) findViewById(R.id.btnStart);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SessionSetting.this, Play.class);
                startActivity(intent);

            }
        });


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExpandable);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("DURATION");
        listDataHeader.add("SOUNDSCAPE");
        listDataHeader.add("AUDIO GUIDANCE");

        // Adding child data
        List<String> duration = new ArrayList<String>();
        duration.add("30 seconds ");
        duration.add("10 minutes");
        duration.add("15 minutes");
        duration.add("20 minutes");
        duration.add("open ended");


        List<String> sound = new ArrayList<String>();
        sound.add("Silence");
        sound.add("Birds");
        sound.add("Windy day");
        sound.add("Coffeeshop");
        sound.add("Fireplace");


        List<String> guidance = new ArrayList<String>();
        guidance.add("No guidance");
        guidance.add("Relaxation");
        guidance.add("Focus");
        guidance.add("Calm mind");
        guidance.add("Happy thoughts");

        listDataChild.put(listDataHeader.get(0), duration); // Header, Child data
        listDataChild.put(listDataHeader.get(1), sound);
        listDataChild.put(listDataHeader.get(2), guidance);


    }
}
package yavor.kolev.myspinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        private ArrayList<SpinnerItem> mItemList;
        private ItemAdapter mAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initList();

            Spinner spinnerItems = findViewById(R.id.spinner_items);

            mAdapter = new ItemAdapter(this, mItemList);
            spinnerItems.setAdapter(mAdapter);

            spinnerItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SpinnerItem clickedItem = (SpinnerItem) parent.getItemAtPosition(position);
                    String clickedCountryName = clickedItem.getItemName();
                    Toast.makeText(MainActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        private void initList() {
            mItemList = new ArrayList<>();
            mItemList.add(new SpinnerItem("Item-1"));
            mItemList.add(new SpinnerItem("Item-2"));
            mItemList.add(new SpinnerItem("Item-3"));
            mItemList.add(new SpinnerItem("Item-4"));
        }
}

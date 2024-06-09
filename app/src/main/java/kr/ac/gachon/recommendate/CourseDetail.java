package kr.ac.gachon.recommendate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;

public class CourseDetail extends AppCompatActivity {

    private static final String TAG = "CourseDetail";

    private FirebaseFirestore db;
    private String courseId;
    private TextView courseNameText, restaurantNameText, cafeNameText, activityNameText;
    private TextView restaurantTagsText, cafeTagsText, activityTagsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_detail);

        db = FirebaseFirestore.getInstance();

        TextView headerTitle = findViewById(R.id.text_header_title);
        headerTitle.setText("데이트");

        // 뒤로가기 버튼 설정
        ImageButton btnArrowBack = findViewById(R.id.btn_arrow_back);
        btnArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티 종료, 이전 화면으로 돌아감
            }
        });

        courseNameText = findViewById(R.id.course_name);
        restaurantNameText = findViewById(R.id.restaurant_name);
        restaurantTagsText = findViewById(R.id.restaurant_tags);
        cafeNameText = findViewById(R.id.cafe_name);
        cafeTagsText = findViewById(R.id.cafe_tags);
        activityNameText = findViewById(R.id.activity_name);
        activityTagsText = findViewById(R.id.activity_tags);

        // 인텐트로 전달된 courseId 받아오기
        Intent intent = getIntent();
        courseId = intent.getStringExtra("courseId");
        Log.d(TAG, "Received courseId: " + courseId); // 로깅 추가

        // Firestore에서 코스 상세 정보 가져오기
        fetchCourseDetails();
    }

    private void fetchCourseDetails() {
        db.collection("courses").document(courseId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    String courseName = document.getString("name");
                    Map<String, Object> restaurant = (Map<String, Object>) document.get("restaurant");
                    Map<String, Object> cafe = (Map<String, Object>) document.get("cafe");
                    Map<String, Object> activity = (Map<String, Object>) document.get("activity");

                    courseNameText.setText(courseName);

                    if (restaurant != null) {
                        restaurantNameText.setText("Restaurant: " + restaurant.get("name"));
                        List<String> restaurantTags = (List<String>) restaurant.get("tags");
                        if (restaurantTags != null) {
                            restaurantTagsText.setText("Tags: " + String.join(", ", restaurantTags));
                        } else {
                            restaurantTagsText.setText("Tags: N/A");
                        }
                    } else {
                        restaurantNameText.setText("Restaurant: N/A");
                        restaurantTagsText.setText("Tags: N/A");
                    }

                    if (cafe != null) {
                        cafeNameText.setText("Cafe: " + cafe.get("name"));
                        List<String> cafeTags = (List<String>) cafe.get("tags");
                        if (cafeTags != null) {
                            cafeTagsText.setText("Tags: " + String.join(", ", cafeTags));
                        } else {
                            cafeTagsText.setText("Tags: N/A");
                        }
                    } else {
                        cafeNameText.setText("Cafe: N/A");
                        cafeTagsText.setText("Tags: N/A");
                    }

                    if (activity != null) {
                        activityNameText.setText("Activity: " + activity.get("name"));
                        List<String> activityTags = (List<String>) activity.get("tags");
                        if (activityTags != null) {
                            activityTagsText.setText("Tags: " + String.join(", ", activityTags));
                        } else {
                            activityTagsText.setText("Tags: N/A");
                        }
                    } else {
                        activityNameText.setText("Activity: N/A");
                        activityTagsText.setText("Tags: N/A");
                    }
                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });
    }
}

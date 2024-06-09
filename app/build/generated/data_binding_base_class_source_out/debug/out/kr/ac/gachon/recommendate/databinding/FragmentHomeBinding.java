// Generated by view binder compiler. Do not edit!
package kr.ac.gachon.recommendate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kr.ac.gachon.recommendate.R;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnOpenMap;

  @NonNull
  public final AppCompatButton btnOpenRecommend;

  @NonNull
  public final ImageView imgMap;

  @NonNull
  public final ListView listRecommendDates;

  @NonNull
  public final TextView textLastDates;

  @NonNull
  public final TextView title;

  private FragmentHomeBinding(@NonNull LinearLayout rootView, @NonNull Button btnOpenMap,
      @NonNull AppCompatButton btnOpenRecommend, @NonNull ImageView imgMap,
      @NonNull ListView listRecommendDates, @NonNull TextView textLastDates,
      @NonNull TextView title) {
    this.rootView = rootView;
    this.btnOpenMap = btnOpenMap;
    this.btnOpenRecommend = btnOpenRecommend;
    this.imgMap = imgMap;
    this.listRecommendDates = listRecommendDates;
    this.textLastDates = textLastDates;
    this.title = title;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_open_map;
      Button btnOpenMap = ViewBindings.findChildViewById(rootView, id);
      if (btnOpenMap == null) {
        break missingId;
      }

      id = R.id.btn_open_recommend;
      AppCompatButton btnOpenRecommend = ViewBindings.findChildViewById(rootView, id);
      if (btnOpenRecommend == null) {
        break missingId;
      }

      id = R.id.img_map;
      ImageView imgMap = ViewBindings.findChildViewById(rootView, id);
      if (imgMap == null) {
        break missingId;
      }

      id = R.id.list_recommend_dates;
      ListView listRecommendDates = ViewBindings.findChildViewById(rootView, id);
      if (listRecommendDates == null) {
        break missingId;
      }

      id = R.id.text_last_dates;
      TextView textLastDates = ViewBindings.findChildViewById(rootView, id);
      if (textLastDates == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new FragmentHomeBinding((LinearLayout) rootView, btnOpenMap, btnOpenRecommend, imgMap,
          listRecommendDates, textLastDates, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

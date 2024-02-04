package com.brandonang.abcdgame;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.view.View;
import com.google.appinventor.components.common.PropertyTypeConstants;

public class ABCDGame extends AndroidNonvisibleComponent {

  // Activity and Context
  private Context context;
  private Activity activity;
  private char letter = 'A';
  private char letterOrdering = 'A'; 
  private char letterNumberOrdering = 'A2';
  private int customizeColor;
  private boolean numberingABCD;

  public ABCDGame(ComponentContainer container) {
    super(container.$form());  
    this.activity = container.$context();
    this.context = container.$context();
  }
    
  @SimpleProperty(description = "Numbering ABCD")  
  public void EnableNumbering(boolean enable){
    numberingABCD = enable;
  }

  @SimpleFunction(description = "Setup The Game")
  public void SetupGame(AndroidViewComponent layout) {
    View view = layout.getView();
    FrameLayout frameLayout = (FrameLayout) view;

    Button button = new Button(this.context);

    if(numberingABCD){ 
      button.setText("A1");
      button.setBackgroundColor(customizeColor);
      button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          switch (letterOrdering) {
            case 'A':
              button.setText("B1");
              letterOrdering = 'B';
              break;
            case 'B':
              button.setText("C1");
              letterOrdering = 'C';
              break;
            case 'C':
              button.setText("D1");
              letterOrdering = 'D';
              break;
            case 'D':
              button.setText("A2");
              letterOrdering = 'A';
              break;
            case 'A2':
             button.setText("B2");
             letterNumberOrdering = 'B';
             break;
            case 'B2':
             button.setText("C2");
             letterNumberOrdering = 'C';
             break;
            case 'C2':
              button.setText("D2");
              letterNumberOrdering = 'D';
              break;
            case 'D2':
             Completed();
             break;
          }
        }
      });
    } else {
      button.setText("A");
      button.setBackgroundColor(customizeColor);
      button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          switch (letter) {
            case 'A':
              button.setText("B");
              letter = 'B';
              break;
            case 'B':
              button.setText("C");
              letter = 'C';
              break;
            case 'C':
              button.setText("D");
              letter = 'D';
              break;
            case 'D':
              Completed();
              break;
          }
        }
      });
    }
    frameLayout.addView(button);
  }

  @DesignerProperty(defaultValue = DEFAULT_VALUE_COLOR_RED, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
  @SimpleProperty(description = "Button Color 1 Game Starts.")
  public void ABCDButtonColor1(int color) {
    customizeColor = color;
  }
    
  @SimpleEvent(description = "When Completed")
  public void Completed(){
    EventDispatcher.dispatchEvent(this, "Completed");
  }
}
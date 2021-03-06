package com.pepedyne.pepe.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.pepedyne.pepe.controller.PepeControlActivity;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class PepeJoyStickView extends JoystickView {

   public PepeJoyStickView(Context context) {
      super(context);
      this.initialize();
   }

   public PepeJoyStickView(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
      this.initialize();
   }

   public PepeJoyStickView(Context context, AttributeSet attrs) {
      super(context, attrs);
      this.initialize();
   }

   @Override
   public boolean performClick() {
      return super.performClick();
   }

   private void initialize() {
      final PepeControlActivity host = (PepeControlActivity) this.getContext();

      this.setOnTouchListener((v, event) -> {
         if (event.getAction() == MotionEvent.ACTION_UP)
         {
            host.getDispatcher().setMove(0, 0);
            performClick();
         }
         return false;
      });

      this.setOnMoveListener((angle, strength) -> {
         host.getDispatcher().setMove(strength, angle);
         host.getDispatcher().calculate();
      });
   }
}

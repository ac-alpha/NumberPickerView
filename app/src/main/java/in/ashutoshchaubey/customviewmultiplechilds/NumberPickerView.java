package in.ashutoshchaubey.customviewmultiplechilds;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by ashutoshchaubey on 12/04/18.
 */

public class NumberPickerView extends LinearLayout {

    Button plusButton, minusButton;
    public static boolean onlyPositive=true;
    public static int value = 0 ;
    EditText valueText;


    public NumberPickerView(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_view_multiple_childs, this,true);
        init(null);
    }

    public NumberPickerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_view_multiple_childs, this,true);
        init(attrs);
    }

    public NumberPickerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_view_multiple_childs, this,true);
        init(attrs);
    }

    public NumberPickerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_view_multiple_childs, this,true);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {

        plusButton = (Button) findViewById(R.id.btn_plus);
        plusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                upDateUI(1);
            }
        });
        minusButton = (Button)findViewById(R.id.btn_minus);
        minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                upDateUI(2);
            }
        });
        valueText=(EditText)findViewById(R.id.edit_text);
        valueText.setText(Integer.toString(value));

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.NumberPickerView);

        onlyPositive=ta.getBoolean(R.styleable.NumberPickerView_onlyPositive,true);
        ta.recycle();

    }

    private void upDateUI(int upOrDown) {

        if(upOrDown==1) {
            value += 1;
            valueText.setText(Integer.toString(value));
//            postInvalidate();
        }else if(upOrDown==2){
            if(value==0 && onlyPositive==true){
                valueText.setText(Integer.toString(value));
            }else{
                value-=1;
                valueText.setText(Integer.toString(value));
//                postInvalidate();
            }
        }

    }

    public static void setValue(int value) {
        NumberPickerView.value = value;
    }

    public static int getValue() {
        return value;
    }
}

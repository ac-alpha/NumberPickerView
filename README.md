# NumberPickerView
This app demonstrates creation of a simple custom view for picking numbers by incrementing or decrementing. The NumberPickerView also demonstrates how to add custom attributes to your custom view.

## Understanding the code
The NumberPickerView.java class inherits from the LinearLayout class. The data items value and onlyPositive specify the current value of displayed number and whether it is positive only or may take negative values.

The init() function takes TypedArray as parameter which is used to extract the attribute values from the xml file.


```
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
```

New attributes are added to the NumberPickerView class by adding a attrs.xml resource file in the values directory

```xml
<resources>
    <declare-styleable name="NumberPickerView">
        <attr name="onlyPositive" format="boolean"/>
    </declare-styleable>
</resources>
```

## Licence
This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

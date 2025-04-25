# 📱 Counter App with Activity Lifecycle

This Android project was built to practice the concepts of the **Activity Lifecycle** and **state preservation** during configuration changes, such as screen rotation.

The app has a simple layout with a button that increases a counter and a `TextView` that displays the current value.

---

## 🧠 Concepts Covered

### ✅ Activity Lifecycle

The following lifecycle methods are implemented and logged:

- `onCreate`: Initializes the layout and sets up UI components.
- `onStart`: Called after `onCreate` or when the activity becomes visible again.
- `onPause`: Called when the activity is partially visible (e.g., when another activity appears).
- `onStop`: Called when the activity is no longer visible.
- `onDestroy`: Called before the activity is destroyed.
- `onSaveInstanceState`: Used to temporarily save the counter value.

All lifecycle methods include `Log.d(TAG, "message")` to log their execution in **Logcat**, making it easy to observe the lifecycle flow.

---

### ✅ State Preservation

When the screen is rotated, the activity is destroyed and recreated. To preserve the counter value, we use:

```kotlin
override fun onSaveInstanceState(outState: Bundle) {
    outState.putInt("myCount", counter)
    super.onSaveInstanceState(outState)
}
 And in onCreate, we restore the saved state:

if (savedInstanceState != null) {
    counter = savedInstanceState.getInt("myCount")
    tv_count.text = counter.toString()
}

📱 Features
Displays a counter on the screen.

Increments the value when the button is clicked.

Preserves the counter value after screen rotation.

Logs lifecycle method calls in Logcat.


🛠️ How to Run

1. Clone the repository:

 git clone https://github.com/your-username/activityApenas.git

2. Open the project in Android Studio.
3. Run the app on an emulator or physical device.

## 📂 Project Structure

 MainActivity.kt

1. var counter = 0  
(Stores the current value of the counter.)

2. val tv_count = findViewById<TextView>(R.id.tv_count)
   val btn_count = findViewById<Button>(R.id.btn_count)
(References to UI elements.)

3. btn_count.setOnClickListener {
    counter += 1
    tv_count.text = counter.toString()
}
(Increments the counter and updates the TextView.)

4. override fun onSaveInstanceState(outState: Bundle) {
    outState.putInt("myCount", counter)
    super.onSaveInstanceState(outState)
}
(Saves the current counter value before the activity is recreated.)

📷 Screenshot


✍️ Author
Made by Paulo

📝 License
This project is open-source and free for study and modification.




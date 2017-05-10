## QuizApp

This is a sandbox project!!!

### versions
- v0.2 mentor suggestions update
- v0.1 initial commit


### v0.2 Mentor suggestions

It's a joy to see that you have implemented for both portrait and landscape orientation. The goal of our app should be to make it efficient on all size of devices.
##### MainActivity.java
1. It is always better to store colors in values/colors.xml. You might want to move RED,GREEN,WHITE variables there
2. Using View to generalize view elements in not good unless you have a strong reason. This could lead to confusion as well as errors. Instead of View howtoLayout; you should use LinearLayout howtoLayout;
3. Instead of repeating these statements in various methods
```
solution1.setVisibility(View.GONE);
solution2.setVisibility(View.GONE);
solution3.setVisibility(View.GONE);
solution1image.setVisibility(View.GONE);
```
you may put them in a method and pass a boolean to make them GONE or VISIBLE. For example toggleSolution(int visiblity)

##### activity_main.xml
1. The correct way to put comment in xml files is `<!-- this is a comment -->`
2. ScrollView uses children height so it make more sense that child of ScrollView uses *wrap*_content instead of *match*_parent
### Adding fragments dynamically to an activity  
  

- we will add list and detail fragments to screen layout dynamically
- and not directly within an XML layout
- add dependency in *app/build.gradle* within *dependencies{ }* 
- which is `FragmentContainerView`, an optimised ViewGroup to handle Fragment Transaction
- ```implementation 'androidx.fragment:fragment-ktx:1.2.5'```
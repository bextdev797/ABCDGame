# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.bextdev.abcdgame.ABCDGame {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/bextdev/abcdgame/repack'
-flattenpackagehierarchy
-dontpreverify

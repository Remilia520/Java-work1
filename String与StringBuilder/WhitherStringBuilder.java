public class WhitherStringBuilder {


 public static String implicit(String[] fields){

  String str = "";

 for (String s : fields){

 str+=s;

 }

 return str;

 }

 public static String explicit (String[] fields){

 StringBuilder sb = new StringBuilder();

 for (String s : fields){

 sb.append(s);

 }

 return sb.toString();

 }

 public static void main(String[] args) {

 int length = 10000;

 String[] fields = new String[length];

 for (int i = 0;i<length;i++){

 fields[i] = "study";

 }

 long beginTime = System.currentTimeMillis();

 implicit(fields);

 System. out .println(System.currentTimeMillis()-beginTime);

 beginTime = System. currentTimeMillis();

 explicit(fields);

 System. out .println(System.currentTimeMillis()-beginTime);

 }

 }

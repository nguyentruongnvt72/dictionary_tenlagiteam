package dictionary;

import java.util.ArrayList;

public class DictionaryCommandline extends DictionaryManagement{

    public  Dictionary listOfAll;
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

//    public void showAllWord(){
//        System.out.println("No    |English          |VietNamese         ");
//        for(int i=0;i<listOfAll.getWords().size() ;i++){
//            result.add( new Word(listOfAll.getWords().get(i).getWord_target(),listOfAll.getWords().get(i).getWord_explain() ));
//            System.out.println( i+1 + "   |" + listOfAll.getWords().get(i).getWord_target() + "       |" + listOfAll.getWords().get(i).getWord_explain());
//
//        }
//    }
//    public void dictionarySearcher(){
//
//        System.out.println("nhap tu can tim: ");
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//
//        for (int i=0;i<result.size();i++){
//            if(result.get(i).getWord_target().startsWith(s)){
//                System.out.println(result.get(i).getWord_target() + "\t");
//            }
//        }
//    }
    public ArrayList<String> dictionarySearcher(String a){
        ArrayList<String> ADD = new ArrayList<>();
        for (int i=0;i<dictionaryManagement.result.size();i++){
            if(dictionaryManagement.result.get(i).getWord_target().startsWith(a))
                ADD.add(dictionaryManagement.result.get(i).getWord_target());
        }
        return ADD;
    }

}

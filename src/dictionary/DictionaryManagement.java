package dictionary;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryManagement {

    public ArrayList<Word> result = new ArrayList<>();
    //ArrayList<Word> words = new ArrayList<>();

    public DictionaryManagement() {
        this.insertFromFile();
    }

    public Word setNewWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap them tu: ");
        String word_target = sc.nextLine();
        System.out.println("nhap nghia: ");
        String word_explain = sc.nextLine();
        result.add(new Word(word_target, word_explain));

        return new Word(word_target.toLowerCase(), word_explain.toLowerCase());
    }
    public void insertFromCommandline(String wordtarget, String wordexplain) {
        Word addWord = new Word(wordtarget, wordexplain);
        result.add(addWord);
    }

    public void insertFromFile(){
        String[] wordsAdd;

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/truongnguyen/Documents/dictionary/src/E_V.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                wordsAdd = line.split("<html>");
                if (wordsAdd.length >= 2) {
                    Word word = new Word(wordsAdd[0], wordsAdd[1]);
                    result.add(word);
                    //words.add(word);
                }
            }
            br.close();
        }catch(FileNotFoundException ex){
            System.out.println("cannot open file: E_V.txt");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public String dictionaryLookup(String value){
        Dictionary dic = new Dictionary();
        String test="";
        for(int i=0;i<result.size();i++) {
            if(value.equals(result.get(i).getWord_target())){
                //System.out.println(result.get(i).getWord_explain());
                test=result.get(i).getWord_explain();
            }
        }
        return test;
    }
    public void Themdulieu(){
        Dictionary dictionary = new Dictionary();
        final String FILENAME = "tu dien.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            String c = "\r\n";
            bw.write(c);
            String content = "girl\tgai";
            bw.write(content);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bw != null)
                    bw.close();
                if(fw != null)
                    fw.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }
    public void dictionnaryExportToFile(){
        File file = new File("xuat du lieu tu dien.txt");
        try(PrintWriter pw = new PrintWriter(file)){
            for(int i=0;i<result.size();i++){
                pw.print(result.get(i).getWord_target() + "\t" + result.get(i).getWord_explain() +"\r\n");
            }

        }catch (Exception e){
        }
    }
    private int binarySearcher(int start, int end, String spelling) {
        if (end < start) return -1;
        int mid = start + (end - start) / 2;
        Word word = result.get(mid);
        String currentSpelling = word.getWord_target();
        if (currentSpelling.startsWith(spelling)) {
            return mid;
        }
        int compare = currentSpelling.compareTo(spelling);
        if (compare == 0) return mid;
        if (compare > 0) return binarySearcher(start, mid - 1, spelling);
        return binarySearcher(mid + 1, end, spelling);
    }


    public ArrayList<String> searcher(String spelling) {
        //ArrayList<Word> resultNew = new ArrayList<>();
        ArrayList<String> resultnew = new ArrayList<>();

        int index =  binarySearcher(0, result.size() - 1, spelling);
//        int index = -1;
        if (index >= 0) {
            resultnew.add(result.get(index).getWord_target());
            int left = index - 1, right = index + 1;

            while (left >= 0) {
                Word leftWord = result.get(left--);
                if (leftWord.getWord_target().startsWith(spelling))
                    resultnew.add(leftWord.getWord_target());
                    //resultnew.add(resultNew.getWord_target());
                else
                    break;
            }

            int length = result.size();
            while (right < length) {
                Word leftWord = result.get(right++);
                if (leftWord.getWord_target().startsWith(spelling))
                    resultnew.add(leftWord.getWord_target());
                else
                    break;
            }
        }
        return resultnew;
    }


}

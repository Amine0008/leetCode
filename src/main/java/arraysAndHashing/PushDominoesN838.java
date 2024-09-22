package arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class PushDominoesN838 {

    public String pushDominoes(String dominoes) {
        char[] dominiePosition = new char[dominoes.length()];
        Set<Integer> movingDominoes = new HashSet<>();
        for(int i = 0; i < dominoes.length(); i++){
            dominiePosition[i] = dominoes.charAt(i);
            if(dominiePosition[i] != '.')
                movingDominoes.add(i);
        }
        Set<Integer> nextMoving;
        while(!movingDominoes.isEmpty()){
            nextMoving = new HashSet<>();
            for(Integer domIndex: movingDominoes){
                if(dominiePosition[domIndex] == 'R'){
                    if(domIndex+1 < dominoes.length()){
                        if(dominiePosition[domIndex+1] == '.'){
                            dominiePosition[domIndex+1] = 'R';
                            nextMoving.add(domIndex+1);
                        }
                        else if(dominiePosition[domIndex+1] == 'L' && nextMoving.contains(domIndex+1)) {
                            nextMoving.remove(domIndex+1);
                            dominiePosition[domIndex+1] = '.';
                        }
                    }

                }
                else{
                    //L
                    if(domIndex-1 >= 0){
                        if(dominiePosition[domIndex - 1] == '.'){
                            dominiePosition[domIndex-1] = 'L';
                            nextMoving.add(domIndex-1);
                        }
                        else if(dominiePosition[domIndex-1] == 'R' && nextMoving.contains(domIndex-1)){
                            dominiePosition[domIndex-1] = '.';
                            nextMoving.remove(domIndex-1);
                        }
                    }

                }
            }
            movingDominoes = nextMoving;
        }
        return new String(dominiePosition);
    }


}

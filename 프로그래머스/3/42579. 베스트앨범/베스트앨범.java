import java.util.*;

class Solution {
    
    public static class Music{
        int idx;
        int play;
        
        public Music(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
    
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for (int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르를 전체 재생수에 대해 정렬
        ArrayList<String> mapToGenre = new ArrayList<>();
        for (String key : map.keySet()){
            mapToGenre.add(key);
        }
        mapToGenre.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        // 장르 내 음악 선정하기
        for (String item : mapToGenre){
            ArrayList<Music> musics = new ArrayList<>();
            for (int i=0; i<genres.length; i++){
                if (item.equals(genres[i])){
                    musics.add(new Music(i, plays[i]));
                }
            }
            
            // 재생 수 기준 정렬
            musics.sort(new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2) {
                    // 재생 수가 동일하면 인덱스 높은것부터
                    if (o1.play == o2.play){
                        return o1.idx - o2.idx;
                    }
                    return o2.play - o1.play;
                }
            });
            
            // 장르 내 2개의 음악을 선택하는데, 1개만 존재할 수도 있음
            answer.add(musics.get(0).idx);
            // 2개 이상인 경우 다음 음악도 추가
            if (musics.size() != 1){
                answer.add(musics.get(1).idx);
            }
        }
        
        
     
        //ArrayList를 int[]로 변환
        return answer;
    }
}
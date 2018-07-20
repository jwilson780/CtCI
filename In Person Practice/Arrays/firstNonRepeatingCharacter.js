char firstNotRepeatingCharacter(String s) {
    int[] ascii = new int[256];
    for(int i = 0; i < s.length(); ++i){
        int numAsc = (int) s.charAt(i);
        ascii[numAsc]++;
    }
    for(int x = 0; x < s.length(); ++x){
        if(ascii[(int) s.charAt(x)] == 1){
            return s.charAt(x);
        }
    }
    return '_';
}

class removeElement {
    public int removeElemente(int[] nums, int val) {
        int i = 0; // Ponteiro para a posição corrente no array

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // Se o elemento não for igual a val, copie-o para a posição atual do ponteiro i
                nums[i] = nums[j];
                i++; // Mova o ponteiro para a próxima posição
            }
        }

        return i; // i agora representa o novo tamanho do array após a remoção dos elementos iguais a val
    }
}
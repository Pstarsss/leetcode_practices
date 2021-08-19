function reverseVowels(s: string): string {
    const vowelArr = ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'];
    if(!vowelArr.some(item => s.includes(item) || s.length === 1)) return s;

    const arr = [...s];
    const result = arr.filter(item => vowelArr.includes(item)).reverse();

    for(let i = 0;i < arr.length;i++) {
        if(!result.length) break;
        
        if(vowelArr.includes(arr[i])) {
            arr[i] = result.shift();
        } 

    }

    return arr.join('');
};
/*
 * @Author: xingpan 
 * @Date: 2023-06-25 19:06:13 
 * @Last Modified by: xingpan
 * @Last Modified time: 2023-06-25 19:25:01
 * ref: https://leetcode.cn/problems/cache-with-time-limit/
 */

interface timeVo {
    value: any;
    duration: number
}

class TimeLimitedCache {
    static timeMap: Map<any, any>;
    constructor() {
        TimeLimitedCache.timeMap = new Map();
    }

    set(key: number, value: number, duration: number): boolean {
        const {timeMap} = TimeLimitedCache;
        if (!timeMap.has(key)) {
            return false;
        }

        const currentTime: number = (new Date()).valueOf();
        const temp: timeVo = {
            value,
            duration: currentTime +  duration
        };
        timeMap.set(key, temp);
        return true;
    }

    get(key: number): number {
        const {timeMap} = TimeLimitedCache;
        const {isValid} = this;
        const temp: number = isValid(key) ? timeMap.get(key) : -1;
        return temp;
    }

	count(): number {
        const {timeMap} = TimeLimitedCache;
        const {isValid} = this;
        const allTime = [...timeMap.keys()]?.filter((key) => isValid(key));

        return allTime?.length || 0;
    }

    isValid(key:number): boolean {
        const {timeMap} = TimeLimitedCache;
        if (!timeMap.has(key)) {
            return false;
        };

        const {duration} = timeMap.get(key);
        const currentTime: number = (new Date()).valueOf();
        const result = !!(currentTime < duration);
        if (!result) {
            timeMap.delete(key);
        }
        return result;
    }
};

let obj = new TimeLimitedCache();
console.log('obj.set(1, 42, 1000);', obj.set(1, 42, 1000));
console.log('obj.get(1);', obj.get(1));
console.log('obj.count();', obj.count());
console.log('obj.get(1);', obj.get(1));

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */
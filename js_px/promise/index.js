/*
 * @Author: xingpan 
 * @Date: 2021-10-08 18:01:23 
 * @Last Modified by: xingpan
 * @Last Modified time: 2021-10-08 19:37:22
 */

class MyPromise {
    constructor(executor) {
        // 初始化默认值；
        this.initValue();

        // 初始化this的指向
        this.initBind();

        // 执行传进来的函数;
        try {
            executor(this.resolve, this.reject);
        } catch(err) {
            this.reject(err);
        } 
    }

    initValue() {
        this.PromiseResult = null; // 终值
        this.PromiseState = 'pending'; // 状态
    }

    initBind() {
        this.resolve = this.resolve.bind(this);
        this.reject = this.reject.bind(this);
    }

    // 对于promise 一旦状态确认了 就不再修改其最终状态；
    resolve(value) {
        if (this.PromiseState !== 'pending') return;
        this.PromiseResult = value;
        this.PromiseState = 'fulfilled';
    }

    reject(value) {
        if (this.PromiseState !== 'pending') return;
        this.PromiseResult = value;
        this.PromiseState = 'rejected';
    }
};

let p = new MyPromise((resolve, reject) => {
    throw('异常')
});
console.log('[', p);
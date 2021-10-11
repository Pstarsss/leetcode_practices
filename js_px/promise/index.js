/*
 * @Author: xingpan 
 * @Date: 2021-10-08 18:01:23 
 * @Last Modified by: xingpan
 * @Last Modified time: 2021-10-11 15:57:18
 */

const FULFILLED = 'fulfilled';
const REJECTED = 'rejected';
const PENDING = 'pending';
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
        this.PromiseState = PENDING; // 状态
        this.onFulfilledCallbacks = [];
        this.onRejectedCallbacks = [];
    }

    initBind() {
        this.resolve = this.resolve.bind(this);
        this.reject = this.reject.bind(this);
    }

    // 对于promise 一旦状态确认了 就不再修改其最终状态；
    resolve(value) {
        if (this.PromiseState !== PENDING) return;
        this.PromiseResult = value;
        this.PromiseState = FULFILLED;

        while (this.onFulfilledCallbacks.length) {
            this.onFulfilledCallbacks.shift()(this.PromiseResult);
        }
    }

    reject(value) {
        if (this.PromiseState !== PENDING) return;
        this.PromiseResult = value;
        this.PromiseState = REJECTED;

        while (this.onRejectedCallbacks.length) {
            this.onRejectedCallbacks.shift()(this.PromiseResult);
        }
    }

    then(onFulfilled, onRejected) {

        onFulfilled = typeof onFulfilled === 'function' ? onFulfilled : (val) => val;
        onRejected = typeof onRejected === 'function' ? onRejected : reason => { throw(reason) };

        var thenPromise = new MyPromise((resolve, reject) => {

            const resolvePromise = cb => {
                setTimeout(() => {
                    try {
                        const x = cb(this.PromiseResult);
    
                        if (x === thenPromise) {
                            // throw new Error('不能返回自身....');
                        }
    
                        if (x instanceof MyPromise) {
                            console.log('x', x);
                            x.then(resolve, reject);
                        } else {
                            console.log('x', x);
                            // 非promise 直接成功
                            resolve(x);
                        }
                    } catch (error) {
                        reject(error);
                    }
                })
            }

            if (this.PromiseState === FULFILLED) {
                resolvePromise(onFulfilled);
            } else if (this.PromiseState === REJECTED) {
                resolvePromise(onRejected);
            } else if (this.PromiseState === PENDING){
                // 如果还是待定状态则存起来  
                this.onFulfilledCallbacks.push(resolvePromise.bind(this, onFulfilled));
                this.onRejectedCallbacks.push(resolvePromise.bind(this, onRejected));
            }
        });

        return thenPromise;
    }
};

// test demo
let p = new MyPromise((resolve, reject) => {
    resolve('成功');
}).then((res) => {
    console.log('res', res)
    return res + 'la'
}, (err) => console.log('err', err))
.then(res => console.log('res1', res), err => console.log('err', err));

console.log('p', p);

// let p1 = new Promise((resovle, reject) => {
//     setTimeout(() => {
//         resovle('成功')
//     }, 1000);
// }).then((res) => console.log('res', res));

// console.log('p1',p1);
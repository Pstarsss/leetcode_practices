/*
 * @Author: xingpan 
 * @Date: 2021-10-09 16:09:20 
 * @Last Modified by: xingpan
 * @Last Modified time: 2021-10-11 11:00:33
 */

function Foo(who) {
    this.me = who;
}

Foo.prototype.identify = function() {
    return `I am ${this.me}`;
}
function Bar(who) {
    Foo.call(this, who);
}

Bar.prototype = Object.create(Foo.prototype);

Bar.prototype.speak = function() {
    console.log(`Hello, ${this.identify()}.`);
}

let b1 = new Bar('b1');
let b2 = new Bar('b2');
console.log(Bar);
console.log(Bar.prototype);


b1.speak();
b2.speak();


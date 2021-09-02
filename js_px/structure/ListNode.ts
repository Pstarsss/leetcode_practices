/*
 * @Author: xingpan 
 * @Date: 2021-09-02 19:25:33 
 * @Last Modified by: xingpan
 * @Last Modified time: 2021-09-02 19:26:29
 */

export class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}
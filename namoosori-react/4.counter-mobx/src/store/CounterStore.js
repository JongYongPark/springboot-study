import { observable, action, makeObservable } from 'mobx';


class CounterStore {

    // observable({
    //     _count = 5,
    // })
    constructor(){
        makeObservable(this);
    }

    @observable
    _count = 5

    get count(){
        return this._count;
    }

    @action
    increment(){
        this._count++;
        console.log(this._count);
    }

    @action
    decrement(){
        this._count--;
        console.log(this._count);
    }

}

export default new CounterStore();
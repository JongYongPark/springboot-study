import { observable, action, computed, makeObservable, toJS } from 'mobx';

class TodoStore {

    constructor(){
        makeObservable(this);
    }

    @observable
    _todos = [ ];

    @observable
    _todo = { }; // id, tiitle, date

    @observable
    _searchText = '';

    @computed 
    get todo(){
        // return this._todo;
        return toJS(this._todo);
    }

    @computed
    get todos(){
        // return this._todos ? this._todos.slice() : [];
        return toJS(this._todos);
    }

    @computed
    get searchText(){
        return this._searchText;
    }

    @action
    setSearchText(searchText){
        this._searchText = searchText;
    }

    @action
    setTodoProps(name, value){
        this._todo = {
            ...this._todo, // 전개 연산자
            [name] : value
        }
    }

    @action
    addTodo(todo){
        this._todos.push(todo);
    }

    @action
    selectedTodo(todo){
        this._todo = todo;
    }

    @action
    updateTodo(){
        let foundTodo = this._todos.find( (todo) => todo.id === this._todo.id );
        foundTodo.title = this._todo.title;
        foundTodo.date = this._todo.date;
        this._todo = {};
    }

    @action
    removeTodo(){
        let index = this._todos.findIndex( (todo) => todo.id === this._todo.id );
        if( index > -1 ){
            this._todos.splice(index,1);
        }
        this._todo = {};
    }

}

export default new TodoStore();
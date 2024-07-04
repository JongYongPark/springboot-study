import './App.css';
import React, { Component } from 'react';
import Nav from './components/Nav';
import About from './components/About'
import Main from './components/Main'
import Lessons from './components/Lessons'
import { Route, Switch } from 'react-router-dom';

class App extends Component {
  render(){
    return (
      <div className="App">
        <Nav />
        <Switch>
          <Route exact path='/' component={Main}></Route>
          <Route exact path='/about' component={About}></Route>
          <Route path='/lessons' component={Lessons}></Route>
        </Switch>
      </div>
    );
  } 
}

export default App;

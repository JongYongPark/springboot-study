import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';

class Nav extends Component {
  render(){
    return (
      <nav className='navtop'>
        <h2>Namoosori</h2>
        <ul className='nav-links'>
          <li><NavLink exact to='/'>Main</NavLink></li>
          <li><NavLink exact to='/about'>About</NavLink></li>
          <li><NavLink exact to='/lessons'>Lessons</NavLink></li>
        </ul>
      </nav>
    )
  }
}

export default Nav;
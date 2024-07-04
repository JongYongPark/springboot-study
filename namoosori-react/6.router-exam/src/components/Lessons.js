import React, { Component } from 'react';
import { Grid, List, ListItem } from '@material-ui/core';
import lessonData from '../static-data/lessonsData';
import { Link, NavLink, Route } from 'react-router-dom';
import Lesson from './Lesson';

class Lessons extends Component {

  render(){

    const links = lessonData.map( lesson => {
      return (
        <ListItem component = 'nav' key={ lesson.id } >
          <NavLink to={'/lessons/'  + lesson.id}> { lesson.name } </NavLink>
        </ListItem>
      )
    } )

    return (
      <Grid container spacing = { 2 }>
        <Grid item>
          <List>{links}</List>
        </Grid>
        <Grid item>
          <Route path='/lessons/:lessonId' component = { Lesson } ></Route>
        </Grid>
      </Grid>
    )
  }
}

export default Lessons;
import React, { PureComponent } from 'react';
import { Table, TableContainer, TableHead, TableBody, TableRow, TableCell, Paper } from '@material-ui/core';
import { observer } from 'mobx-react';
import moment from 'moment';

@observer
class TodoListView extends PureComponent {
  render(){

    // const sample = [{id: 1, title:'title1', date:'date1'}, {id: 2, title:'title2', date:'date2'}]
    const { todos, onSelectedTodo } = this.props;

    return (
      <TableContainer component={Paper} >
        <Table m={3}>
          <TableHead>
            <TableRow>
              <TableCell align='center'>Title</TableCell>
              <TableCell align='center'>Date</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {
              // sample.map( (todo ) => (  
              Array.isArray(todos) && todos.length ? 
              todos.map( (todo ) => (  
              <TableRow 
                key = { todo.id } 
                hover onClick = { () => onSelectedTodo(todo) }>
                <TableCell>{ todo.title }</TableCell>
                <TableCell>{ moment(todo.date).format('YYYY-MM-DD HH:mm') }</TableCell>
              </TableRow>
              
              ) )
              :
              <TableRow>
                <TableCell>Empty</TableCell>
              </TableRow>
            }
            
          </TableBody>
        </Table>
      </TableContainer>
    )
  }
}

export default TodoListView;
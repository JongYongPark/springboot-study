import React, { Component } from 'react';
import { Button, Box } from '@material-ui/core';
import { inject, observer } from 'mobx-react';

@inject('counterStore')
@observer
class CounterComponent extends Component {

  render(){

    const { counterStore } = this.props;

    return(
      <div>
        <Button variant='contained' color='primary' size='large' onClick={ () => counterStore.decrement() } > - </Button>        
        
        <Box component='span' m={5}> { counterStore.count } </Box>
        
        <Button variant='contained' color='primary' size='large' onClick={ () => counterStore.increment() } > + </Button>
      </div>
    )
  }
}

export default CounterComponent;
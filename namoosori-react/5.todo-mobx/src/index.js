import { Provider } from 'mobx-react';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import reportWebVitals from './reportWebVitals';
import TodoStore from './store/TodoStore';

ReactDOM.render(
  <Provider todoStore = { TodoStore }>
    <App />
  </Provider>,
  document.getElementById('root')
);

reportWebVitals();

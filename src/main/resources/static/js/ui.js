$(document).ready(function() {
  const ui = window.ui || {};
  window.ui = ui;

  $.datetimepicker.setLocale('ko');
  $('#start').datetimepicker({
    format: 'Y-m-d H:i'
  });
  $('#end').datetimepicker({
    format: 'Y-m-d H:i'
  });

  $("#button-for-make-visualize").on('click', function (e) {
    e.preventDefault();

    const searchDataForVisual = {
      clinchingType: $('#clinching-type').val(),
      start: new Date($('#start').val()).toISOString(),
      end: new Date($('#end').val()).toISOString()
    };

    $.get('/api/make-visualize', searchDataForVisual, function(data, status) {
      if(status === 'success') {
        makeChart.draw(data);
      }
    });
  });

  //$("#my_form").on('submit', function (e) {
  $("#button").on('click', function (e) {
    e.preventDefault();

    const searchData = {
      clinchingType: $('#clinching-type').val(),
      operationResult: $('#operation-result').val(),
      monitoringResult: $('#monitoring-result').val(),
      start: new Date($('#start').val()).toISOString(),
      end: new Date($('#end').val()).toISOString()
    };

    $('#dmc-search-list').DataTable( {
      dom: 'Bfrtip',
      destroy: true,
      ajax: {
        url: '/api/search-dmc',
        type: 'GET',
        data: searchData,
        dataSrc: ''
      },
      columns: [
        { data: 'mfd' },
        { data: 'clinchingType' },
        { data: 'dmc' },
        { data: 'operationResult' },
      ],
      order: [[ 0, 'asc' ]]
    });
  });
});


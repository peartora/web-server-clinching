$(document).ready(function() {
    Chart.register('chartjs-plugin-annotation');

    const makeChart = window.makeChart || {};
    window.makeChart = makeChart;

    let theChart = null;

    const colors = [
        "rgb(98, 171, 221)",
        "rgb(130, 143, 181)",
        "rgb(193, 228, 151)",
        "rgb(69, 111, 147)",
        "rgb(94, 60, 211)",
        "rgb(160, 205, 181)",
        "rgb(225, 106, 218)",
        "rgb(190, 130, 82)",
        "rgb(95, 69, 233)",
        "rgb(153, 176, 165)",
        "rgb(153, 69, 165)"
    ];

    function draw(datas) {

        datas.sort((a,b) => a.mfd.localeCompare(b.mfd));

        const datasets = [];

        const annotations = { };

        if (datas.length == 0) {
            return;
        }

        const type = datas[0].clinchingType;

        if(type === 'BRACKET')
        {
            annotations.up = {
                type: 'line',
                yMin: 20200,
                yMax: 20200,
                borderColor: 'rgb(255, 99, 132)',
                label: {
                    content: "Upper LIMIT",
                    position: 'start',
                    enabled: true,
                }
            }
            annotations.down = {
                type: 'line',
                yMin: 11500,
                yMax: 11500,
                borderColor: 'rgb(255, 99, 132)',
                label: {
                    content: "Lower LIMIT",
                    position: 'start',
                    enabled: true,
                }
            }
        }
        else if (type == 'HOUSING')
        {
            annotations.up = {
                type: 'line',
                yMin: 18100,
                yMax: 18100,
                borderColor: 'rgb(255, 99, 132)',
                label: {
                    content: "Upper LIMIT",
                    position: 'start',
                    enabled: true,
                }
            }
            annotations.down = {
                type: 'line',
                yMin: 11100,
                yMax: 11100,
                borderColor: 'rgb(255, 99, 132)',
                label: {
                    content: "Lower LIMIT",
                    position: 'start',
                    enabled: true,
                }
            }
        } else {
            alert(`${type} type은 그릴 수 없는 그레프 입니다.`);
            return;
        }

        console.log('empty datasets');
        console.log(JSON.stringify(datasets)); // 초기화를 하였는데 CP에 대한 값이 들어 있는 이유?

        const endForceByCp = {};
        let clamping_position;

        for (const item of datas) {
            clamping_position = item['cp'];
            if (!endForceByCp[clamping_position]) {
                endForceByCp[clamping_position] = [];
            }

            endForceByCp[clamping_position].push({
                x: dateFns.format(new Date(item['mfd']), 'YYYY-MM-DD'),
                y: item['averageEndForceValue']
            })
        }

        for (const key in endForceByCp) {
            const label = key;
            const data = endForceByCp[key];

            datasets.push({
                label: label, // cp
                data: data, // end_force_values
                borderColor: colors[datasets.length]
            })
        }

        console.log('fill datasets');
        console.log(datasets);

        const data = {
            // labels: mfd,
            datasets: datasets
        };

        const config = {
            type: 'line',
            data: data,
            options: {
                maintainAspectRatio: true,
                responsive: false,
                scales: {
                    y: {
                        suggestedMin: 10000,
                        suggestedMax: 22000
                    }
                },
                plugins: {
                    autocolors: false,
                    annotation: {
                        annotations: annotations
                    }
                }
            }
        };

        if (theChart) {
            theChart.destroy();
        }

        theChart = new Chart(
            document.getElementById('myChart'),
            config
        );
    }
    makeChart.draw = draw;
})
/*******************************************************************************
 * Copyright (c) 2017, 2018 Ericsson
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.tracecompass.examples.ui.viewers.histogram;

import java.util.Comparator;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.tracecompass.internal.examples.histogram.HistogramDataProvider;
import org.eclipse.tracecompass.internal.examples.histogram.Messages;
import org.eclipse.tracecompass.internal.provisional.tmf.core.model.tree.TmfTreeDataModel;
import org.eclipse.tracecompass.tmf.ui.viewers.tree.AbstractSelectTreeViewer;
import org.eclipse.tracecompass.tmf.ui.viewers.tree.ITmfTreeColumnDataProvider;
import org.eclipse.tracecompass.tmf.ui.viewers.tree.TmfGenericTreeEntry;
import org.eclipse.tracecompass.tmf.ui.viewers.tree.TmfTreeColumnData;

import com.google.common.collect.ImmutableList;

/**
 * Tree viewer to select which trace to display in the New Histogram chart
 * chart.
 *
 * @author Loic Prieur-Drevon
 */
@SuppressWarnings("restriction")
public class HistogramTreeViewer extends AbstractSelectTreeViewer {

    private class HistogramLabelProvider extends TreeLabelProvider {

        @Override
        public String getColumnText(Object element, int columnIndex) {
            if (columnIndex == 0 && element instanceof TmfGenericTreeEntry) {
                TmfGenericTreeEntry<TmfTreeDataModel> genericEntry = (TmfGenericTreeEntry<TmfTreeDataModel>) element;
                return genericEntry.getName();
            }
            return null;
        }

        @Override
        public Image getColumnImage(Object element, int columnIndex) {
            if (columnIndex == 1 && element instanceof TmfGenericTreeEntry && isChecked(element)) {
                TmfGenericTreeEntry<TmfTreeDataModel> genericEntry = (TmfGenericTreeEntry<TmfTreeDataModel>) element;
                return getLegendImage(genericEntry.getModel().getName());
            }
            return null;
        }
    }

    /**
     * Constructor
     *
     * @param parent
     *            the parent {@link Composite}
     */
    public HistogramTreeViewer(Composite parent) {
        super(parent, 1, HistogramDataProvider.ID);
        setLabelProvider(new HistogramLabelProvider());
    }

    @Override
    protected ITmfTreeColumnDataProvider getColumnDataProvider() {
        return () -> {
            return ImmutableList.of(createColumn(Messages.NewHistogramTree_ColumnName, Comparator.comparing(TmfGenericTreeEntry::getName)),
                    new TmfTreeColumnData(Messages.NewHistogramTree_Legend));
        };
    }

}
